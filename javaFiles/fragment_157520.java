Map map1 = [ 444: 'aaa', 555: 'bbb', 666: 'zzz' ]
Map map2 = [ 444: [ 'cc', 'dd', 'ff' ], 666: ['111', '222'] ]

map1.keySet().each { key ->
    List v2 = map2[key]
    if ( v2 ) {
       println (([map1[key]] + v2).join("."))
    }
}