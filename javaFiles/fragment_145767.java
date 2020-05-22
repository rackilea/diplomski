class FOO {}


def params = [:]

alter = { 
  params.alter = it
  [add : { 
      params.add = it
      [storing: { 
          params.clazz = it
          [:].withDefault { params.param = it }
      }]
  }]
}


alter 't' add 'a' storing FOO 42


assert params == [
  alter : 't',
  add   : 'a',
  clazz : FOO,
  param : '42'
]