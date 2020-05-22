//i think better to have just a map for this task for faster access
//you can convert your list of maps to map: list1.collectEntries{[it.name,it.value]}
def map1 = [:]
map1['abcd'] = '1.2.3'
map1['xyx'] = '4.6.3'

def map2 = [:]
map2['abcd'] = '1.2.6'
map2['xyx'] = '4.6.3'

map1.each{k1,v1->
    def v2 = map2[k1]
    if(v1!=v2) println "the value of $k1 in list1 `$v1` is "+( v1>v2 ? "greater" : "less" ) +" then `$v2` in list2"
}