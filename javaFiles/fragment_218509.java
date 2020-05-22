ArrayList<int[]> lijstje = new ArrayList<int[]>();
public int[] data = {7,4,8,56,67,85,23,65,23,65,23,22};
int stemp;
int len = 10;
public void shellSort(){
    while (h <= len / 3) {
        h = h * 3 + 1;
    }
    while (h > 0) {

        for (outer = h; outer < len; outer++) {
            stemp = data[outer];
            inner = outer;

            while (inner > h - 1 && data[inner - h] >= stemp) {
                data[inner] = data[inner - h];
                inner -= h;
            }
            data[inner] = stemp;
            lijstje.add(data.clone()); // Notice here how it's data.clone() instead of just data
        }
        h = (h - 1) / 3;
    }
}