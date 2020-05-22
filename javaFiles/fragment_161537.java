if (type == KRB5_NT_SRV_HST) {
        struct addrinfo *ai = NULL, hints;
        int err;
        char hnamebuf[NI_MAXHOST];

        /* Note that the old code would accept numeric addresses,
           and if the gethostbyaddr step could convert them to
           real hostnames, you could actually get reasonable
           results.  If the mapping failed, you'd get dotted
           triples as realm names.  *sigh*

           The latter has been fixed in hst_realm.c, but we should
           keep supporting numeric addresses if they do have
           hostnames associated.  */

        memset(&hints, 0, sizeof(hints));
        hints.ai_flags = AI_CANONNAME;
        err = getaddrinfo(hostname, 0, &hints, &ai);
        if (err) {
#ifdef DEBUG_REFERRALS
            printf("sname_to_princ: failed to canonicalize %s; using as-is", hostname);
#endif
        }
        remote_host = strdup((ai && ai->ai_canonname) ? ai->ai_canonname : hostname);
        if (!remote_host) {
            if(ai)
                freeaddrinfo(ai);
            return ENOMEM;
        }

        if ((!err) && maybe_use_reverse_dns(context, DEFAULT_RDNS_LOOKUP)) {
            /*
             * Do a reverse resolution to get the full name, just in
             * case there's some funny business going on.  If there
             * isn't an in-addr record, give up.
             */
            /* XXX: This is *so* bogus.  There are several cases where
               this won't get us the canonical name of the host, but
               this is what we've trained people to expect.  We'll
               probably fix it at some point, but let's try to
               preserve the current behavior and only shake things up
               once when it comes time to fix this lossage.  */
            err = getnameinfo(ai->ai_addr, ai->ai_addrlen,
                              hnamebuf, sizeof(hnamebuf), 0, 0, NI_NAMEREQD);
            freeaddrinfo(ai);
            if (err == 0) {
                free(remote_host);
                remote_host = strdup(hnamebuf);
                if (!remote_host)
                    return ENOMEM;
            }
        } else
            freeaddrinfo(ai);
    }