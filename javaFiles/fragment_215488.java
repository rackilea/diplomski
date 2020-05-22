package com.sample.cache;

import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.transaction.TransactionAwareCacheManagerProxy;

public class TransactionAwareCacheManager extends TransactionAwareCacheManagerProxy {
   public TransactionAwareCacheManager() {
      super(new ConcurrentMapCacheManager());
   }
}