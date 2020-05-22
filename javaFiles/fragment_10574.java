>>> m = gateway.jvm.java.util.HashMap()
>>> m["a"] = 0
>>> m.put("b",1)
>>> m
{u'a': 0, u'b': 1}
>>> u"b" in m
True
>>> del(m["a"])
>>> m
{u'b': 1}
>>> m["c"] = 2