const string = "learning to program"

function count(character) {
 return string.split(character).length
}

map = string.split("").map(c => {
 return {c, count: count(c)}
})

map.sort((a,b) => b.count - a.count)

console.log(map)