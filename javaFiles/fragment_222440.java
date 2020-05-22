Q <- new Queue() //or even better - priority queue that holds the highest point at the top
Q.push((x,y,height)
visited[width][depth]; //init as all false
while Q.empty() == false:
   curr <- Q.pop()
   if (sanity check for x<0 , y< 0 ,..):
      continue
   if visited[x][y] == true:
      continue
   if height <= 0: //or some epsilon instead of 0 if there are floating point issues
      continue
   heights[x][y] = height
   visited[x][y] = true
   Q.push(x+1,y,calculateNewHeight(...))
   ... //similarly for all directions