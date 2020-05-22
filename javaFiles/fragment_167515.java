int left = max(obj1.left, obj2.left)
int right = min(obj1.right, obj2.right)
int top = min(obj1.top, obj2.top)
int bottom = max(obj1.bottom, obj2.bottom)

for (int x = left; x < right; x++) {
  for (int y = top; y < bottom; y++) {
     if (obj1.isFilled(x,y) && obj2.isFilled(x,y)) {
        return true;
     }
  }
}