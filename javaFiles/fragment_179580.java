void  clear() {
577             if (count != 0) {
578                 lock();
579                 try {
580                     HashEntry<K,V>[] tab = table;
581                     for (int i = 0; i < tab.length ; i++)
582                         tab[i] = null;
583                     ++modCount;
584                     count = 0; // write-volatile
585                 } finally {
586                     unlock();
587                 }
588             }
589         }
590     }