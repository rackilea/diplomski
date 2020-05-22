<other ops>
[StoreStore]
[LoadStore]
x = 1; // volatile store
[StoreLoad] // Case (a): Guard after volatile stores

...

[StoreLoad] // Case (b): Guard before volatile loads
int t = x; // volatile load
[LoadLoad]
[LoadStore]
<other ops>