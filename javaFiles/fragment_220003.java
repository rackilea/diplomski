1.1.1: entered: ...
1.2.1: created; v.i = 15
1.2.2: changed: v.i = 25

1.3.1: before calling second(v) ...
 v.i = 25, v.hashCode() = 1671711; v = Test$Value@19821f
 2.1.1: entered: v.i = 25
 2.1.2: v.hashCode() = 1671711; v = Test$Value@19821f
 2.2.1:   new V: v.i = 9
 2.2.2: v.hashCode() = 11394033; v = Test$Value@addbf1
1.3.2: returning from second(v) ...
 v.i = 25, v.hashCode() = 1671711; v = Test$Value@19821f

1.4.1:  before calling third(v) ...
 v.i = 25, v.hashCode() = 1671711; v = Test$Value@19821f
 3.1.1:  entered: v.i = 25
 3.1.2:  v.hashCode() = 1671711; v = Test$Value@19821f
 3.2.1:  created: v.i = 9
 3.2.2:  v.hashCode() = 4384790; v = Test$Value@42e816
1.4.2:  returning from third(v) ...
 v.i = 9, v.hashCode() = 4384790; v = Test$Value@42e816

1.5.1: before calling fourth(v) ...
 v.i = 9, v.hashCode() = 4384790; v = Test$Value@42e816
 4.1.1:entered: v.i = 9
 4.1.2:v.hashCode() = 4384790; v = Test$Value@42e816
 4.2.1:changed: v.i = 45
 4.2.2:v.hashCode() = 4384790; v = Test$Value@42e816
1.5.2: returning from fourth(v) ...
 v.i = 45, v.hashCode() = 4384790; v = Test$Value@42e816