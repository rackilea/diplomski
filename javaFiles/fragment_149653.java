Model{id=1, nodeName='name', nodeType='STRING', nodeValue='Jake'} => Parent: Model{id=0, nodeName='ROOT', nodeType='null'}
Model{id=2, nodeName='salary', nodeType='NUMBER', nodeValue='3000'} => Parent: Model{id=0, nodeName='ROOT', nodeType='null'}
Model{id=3, nodeName='phones', nodeType='ARRAY'} => Parent: Model{id=0, nodeName='ROOT', nodeType='null'}
Model{id=4, nodeName='arrayElement', nodeType='OBJECT'} => Parent: Model{id=3, nodeName='phones', nodeType='ARRAY'}
Model{id=5, nodeName='phoneType', nodeType='STRING', nodeValue='cell'} => Parent: Model{id=4, nodeName='arrayElement', nodeType='OBJECT'}
Model{id=6, nodeName='phoneNumber', nodeType='STRING', nodeValue='111-111-111'} => Parent: Model{id=4, nodeName='arrayElement', nodeType='OBJECT'}
Model{id=7, nodeName='arrayElement', nodeType='OBJECT'} => Parent: Model{id=3, nodeName='phones', nodeType='ARRAY'}
Model{id=8, nodeName='phoneType', nodeType='STRING', nodeValue='work'} => Parent: Model{id=7, nodeName='arrayElement', nodeType='OBJECT'}
Model{id=9, nodeName='phoneNumber', nodeType='STRING', nodeValue='222-222-222'} => Parent: Model{id=7, nodeName='arrayElement', nodeType='OBJECT'}
Model{id=10, nodeName='taskIds', nodeType='ARRAY'} => Parent: Model{id=0, nodeName='ROOT', nodeType='null'}
Model{id=11, nodeName='arrayElement', nodeType='NUMBER', nodeValue='11'} => Parent: Model{id=10, nodeName='taskIds', nodeType='ARRAY'}
Model{id=12, nodeName='arrayElement', nodeType='NUMBER', nodeValue='22'} => Parent: Model{id=10, nodeName='taskIds', nodeType='ARRAY'}
Model{id=13, nodeName='arrayElement', nodeType='NUMBER', nodeValue='33'} => Parent: Model{id=10, nodeName='taskIds', nodeType='ARRAY'}
Model{id=14, nodeName='address', nodeType='OBJECT'} => Parent: Model{id=0, nodeName='ROOT', nodeType='null'}
Model{id=15, nodeName='street', nodeType='STRING', nodeValue='101 Blue Dr'} => Parent: Model{id=14, nodeName='address', nodeType='OBJECT'}
Model{id=16, nodeName='city', nodeType='STRING', nodeValue='White Smoke'} => Parent: Model{id=14, nodeName='address', nodeType='OBJECT'}