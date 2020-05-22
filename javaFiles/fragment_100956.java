//You would call this method to search. 
string query(string param1, string param2, string param3)
{
    // The essence of the logic is, if you give a value for param3,
    // then it will do the subquery of the hashMap that param3
    // is the key of, if you don't supply a value (or provide the wildcard)
    // it will search all the different hashmaps of the parent hashmap.
    // See below for an example
    if param1 != WILDCARD
    then subquery1(hashmap[param1], string param2, string param3);
    else for each x in hashmap, subquery1(x,string param2, string param3)
}

string subquery1(hashmap[hashmap[]] maps, string param2, string param3)
{
    // The essence of the logic is, if you give a value for param2,
    // then it will do the subquery of the hashMap that param2
    // is the key of, if you don't supply a value (or provide the wildcard)
    // it will search all the different hashmaps of the parent hashmap.
    if param2 != WILDCARD
    then subquery2(maps[param2], string param3);
    else for each x in maps, subquery2(x, string param3)
}

string subquery2(hashmap[] maps, string param3)
{
    if param3 != WILDCARD
    then return maps[param3]
    else for each x in maps, return maps[param3]
}