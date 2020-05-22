if(keyStore.size() > nodeMap.getLength())
              return false;
          int count = 0;
          for (String key: keyStore.keySet())
          {
             if(keyStore.get(key) != nodeMap.item(count).getNodeValue())
                 return false;
          }
          return true;