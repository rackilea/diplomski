HashMap<String, List> map = new HashMap<String, List>()

map.put("Alex", [12,18])
map.put("Bob", [13,45])
map.put("Ball", [13,45])
map.put("Candy", [1,2])

println map.sort {a,b -> b.value.sum() <=> a.value.sum()}