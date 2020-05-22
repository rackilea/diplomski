String hashUser = SHA1.Sha1Hash(username);
            String hashPass = SHA1.Sha1Hash(password);

            /**
             * HASH USERNAME
             * sha1(concat(sha1(substr(concat(sha1('username'),sha1('password')),20,35)),sha1('username')))
             */
            String userPLUSpass = hashUser+hashPass;
            String userConcat = "";  
            String subStringUserHash = userConcat.concat(userPLUSpass);
            String userHashSubStr = SHA1.Sha1Hash(subStringUserHash.substring(19, 54));
            String luser = userHashSubStr+hashUser;
            String uConcat = "";            
            lastUser = SHA1.Sha1Hash(uConcat.concat(luser));

            /**
             * HASH PASSWORD
             * sha1(concat(sha1(substr(concat(sha1('password'),sha1('username')),10,35)),sha1('password')))
             */
            String passPLUSuser = hashPass+hashUser;
            String passConcat = "";  
            String subStringPassHash = passConcat.concat(passPLUSuser);
            String passHashSubStr = SHA1.Sha1Hash(subStringPassHash.substring(9, 44));
            String lpass = passHashSubStr+hashPass;
            String pConcat = "";            
            lastPass = SHA1.Sha1Hash(pConcat.concat(lpass));