// Boxed Long, can be null to mean that you might not have a token.
// You could also use Optional or something similar.
Long tokenFromRequest;

// Might be the same as the incoming token or a new one.
Long tokenToReturn;

IndexSearcher is;
if (tokenFromRequest == null) { // no previous token, need a new one
  is = manager.acquire(); // get searcher from SearcherManager
  tokenToReturn = mgr.record(is); // get a fresh token for this searcher
} else {
  is = mgr.acquire(tokenFromRequest); // try to get the recorded searcher
  if (is != null) { // token is valid
    tokenToReturn = tokenFromRequest;
  } else {
    is = manager.acquire(); // get searcher from SearcherManager
    tokenToReturn = mgr.record(is); // get a token for this searcher
  }
}

try {
  // Do searching, doc retrieval, etc. with is
} finally {
  if (tokenToReturn == tokenFromRequest) {
    // token was valid, we need to release the searcher
    // to the LifetimeManager, the SearcherManager had
    // nothing to do with this IndexSearcher
    mgr.release(is);
  } else {
    // we got this searcher from SearcherManager,
    // the LifetimeManager records its usage as well and
    // we need to release it to show that _we_ are finished
    // using it, otherwise it would be kept open forever
    manager.release(is);
  }

}
// Do not use is after this!
is = null;

//return tokenToReturn to user to be sent with the next request