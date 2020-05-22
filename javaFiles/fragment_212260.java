public static List<Object>[] splitIn(List<Object> objects, int i) {

    int base_objects = objects.size() / i;
    int modulo_objects = objects.size() % i;
    int[] colSize = new int[i];

    switch (modulo_objects) {
        case 0:
            colSize[0] = base_objects;
            colSize[1] = base_objects;
            colSize[2] = base_objects;
            break;
        case 1:
            colSize[0] = base_objects;
            colSize[1] = base_objects + 1;
            colSize[2] = base_objects;
            break;
        case 2:
            colSize[0] = base_objects + 1;
            colSize[1] = base_objects;
            colSize[2] = base_objects + 1;
            break;
    }

    List<Object>[] columns = new List[i];

    int count = 0;
    for (int x = 0; x < i; x++) {
        List<Object> col_objects = new ArrayList();
        int colCount = 0;
        while (colCount < colSize[x]) {
            Object Object = (Object) objects.get(count);
            col_objects.add(Object);
            colCount++;
            count++;
        }
        columns[x] = col_objects;
    }
    return columns;
}






#{list cols, as:'column'}
  <td width="220" align="center" style="padding-right: 15px;">
      #{list column, as:'object'}
                <h1><a href="@{Objects.show(object.urlName())}" >${object.name}</a></h1>
      #{/list}
   </td>
   #{/list}