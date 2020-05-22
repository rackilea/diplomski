let m = "" 
print(Array(m.utf16).map { String($0, radix: 16)} ) // ["d83d", "de00"]

let t = "a€" 
print(Array(t.utf16).map { String($0, radix: 16)} ) // ["61", "20ac"]

let e = xorMessage(message: m, key: t)
print(Array(e.utf16).map { String($0, radix: 16)} ) // ["fffd", "feac"]

let d = xorMessage(message: e, key: t)
print(Array(d.utf16).map { String($0, radix: 16)} ) // ["ff9c", "fffd"]

print(d) // ﾜ�
print(d == m) // false