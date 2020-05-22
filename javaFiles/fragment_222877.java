while (result != null) {
            if (result.next != null)
            System.out.print(result.data + "--->");
            else System.out.println(result.data);
            result = result.next;
        }