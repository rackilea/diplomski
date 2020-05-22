string = 'Michael Wigglesworth, like Taylor an Englishborn, Harvard-educated Puritan minister.'
delete = [1, 2, 3, 4, 5]
add = {
    1: 'Wigglesworth',
    2: 'is',
    3: 'a',
    4: 'handsome',
    5: 'men',
    6: 'who',
    7: 'is'
}
words = string.split()
for i in delete[::-1]:
    words.pop(i)
for i, word in add.items():
    words.insert(i, word)
print(' '.join(words))