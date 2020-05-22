>>> import re
>>> import pprint
>>> t = ["assertEquals(az, bz);", \
...      "assertEquals(az(), bz);", \
...      "assertEquals(az, bz());", \
...      "assertEquals(az, bz(dz));", \
...      "assertEquals(bz(dz), az);", \
...      "assertEquals(az, bz(cz, dz));", \
...      "assertEquals(bz(cz, dz), az);"]
>>> var = r'([a-z]+(\(([a-z]+(\s*,\s*[a-z]+)*)?\))?)'
>>> res = [ \
...     re.sub( \
...            r'assertEquals\(\s*' + var + '\s*,\s*' + var + '\s*\)', \
...            r'\1 == \5', str \
...           ) \
...     for str in t]
>>> pprint.pprint(res)
['az == bz;',
 'az() == bz;',
 'az == bz();',
 'az == bz(dz);',
 'bz(dz) == az;',
 'az == bz(cz, dz);',
 'bz(cz, dz) == az;']