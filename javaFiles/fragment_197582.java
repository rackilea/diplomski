public V get(K key){
        int keyIndex = getHashCode(key);

        if(table[keyIndex] == null){
          return null;
        }
        else{
          HashEntry<K,V> temp = table[keyIndex];          
          while(temp != null){
            if(temp.key.equals(key)){
              return temp.value;
            }
            temp = temp.next;
          }
          return temp.value;
        }

      }