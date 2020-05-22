public class ServerMetricsTask {
...
            for (MachineStats stats : listOfServers) {
                //now what should I do here?
                // I guess I need to iterate fieldHolder map
                HashMap<String, int> keymap = stats.getKeyMap();
                int key_count = keymap.size();
                int valid_count = 0;
                Set<String> keys = keymap.keySet();
                for (String key : keys) {
                    int count = keymap.get(key);
                    int result = TestUtils.extractKey(key, stats.getServerName(), stats.getServerURL());
                    if (stats.isEligibleForEmail(result, thresholdLimit)) {
                        count++;
                    } else {
                        // here you can do count = 0 if you need strictly continuous appearance of the key
                    }
                    keymap.put(key, count);
                    if (count >= 3) valid_count++;
                }
                // now decide if you need all keys to be valid or just some
                if (valid_count == key_count) holder.add(stats.getServerName());
...