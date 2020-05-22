cell = [1, 3, 2, 6, 5, 7, 9, 8, 10, 8, 11]
maxToLeft = cell[0]
answer = -1
for checking in range(1, len(cell) - 1):
    if answer == -1:
        if cell[checking] > maxToLeft:
            answer = checking
    else:
        if cell[answer] >=cell[checking]:
            answer = -1
    if cell[checking] > maxToLeft:
        maxToLeft = cell[checking]

if answer != -1:
    if cell[len(cell] - 1] <= cell[answer]:
        answer = -1

if answer == -1:
    print ("Not found")
else:
    print("Found value", cell[answer], "at index", answer);


print(highLeft)
print(cell)
print(lowRight)

for idx in range(1, len(cell) - 1):
    if cell[idx] > highLeft[idx] and cell[idx] < lowRight[idx]:
        print("Found value", cell[idx], "at index", idx)