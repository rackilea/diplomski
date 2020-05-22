String[] keys = map.keySet().toArray(new String[map.size()]);
Double[] values = map.values().toArray(new Double[map.size()]);

for(int x=1; x<values.length; x++)
    values[x] += values[x-1];            //Accumulate probabilities

double rand = Math.random();
for(int x=0; x<values.length; x++){
    if(rand < values[x])
        System.out.println(keys[x]);
        break;
    }