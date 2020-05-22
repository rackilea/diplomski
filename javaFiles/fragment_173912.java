>>> x = patricia()
>>> x.addWord('abcabc')
>>> x._d
{'a': ['bcabc', {}]}
>>> x.addWord('abcdef')
>>> x._d
{'a': ['bc', {'a': ['bc', {}], 'd': ['ef', {}]}]}
>>> x.addWord('abc')
{'a': ['bc', {'a': ['bc', {}], '': ['', {}], 'd': ['ef', {}]}]}