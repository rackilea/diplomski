function scratch_array_keyed_hashmap
import test.EqualByValueDoubleArray;
map = java.util.HashMap;
a = [1 2 3 4 5]';

key = EqualByValueDoubleArray(a);
map.put(key, 'my value');
% Separate key so we know it's comparing by value, not Java object identity
key2 = EqualByValueDoubleArray(a);
gotBack = map.get(key2)