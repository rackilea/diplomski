static Scanner ler;
    public static void menuClientes(){
        int op= 0;

        while (op!= 5){
            System.out.println("1 - Listar clientes");
            System.out.println("2 - Adicionar clientes");
            System.out.println("3 - Modificar clientes");
            System.out.println("4 - Eliminar clientes");
            System.out.println("5 - Voltar");
            System.out.println("OP-> ");
            op = ler.nextInt();

            switch (op) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            default:
                System.out.println("Opção inválida");
            }
        }
    }

    public static void menuTransporte(){
        int op= 0;

        while (op!= 5){
            System.out.println("1 - Listar transporte");
            System.out.println("2 - Adicionar transporte");
            System.out.println("3 - Modificar transporte");
            System.out.println("4 - Eliminar transporte");
            System.out.println("5 - Voltar");
            System.out.println("OP-> ");
            op = ler.nextInt();
            switch (op) {
            case 1:
                break;

            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            default:
                System.out.println("Opção inválida");
            }
        }
    }

    public static void menuPrincipal(){
        int op= 0;

        while (op!= 5){
            System.out.println("1 - Visualizar lista encomendas realizadas");// visualize
            System.out.println("2 - Listar/adicionar/modificar/eliminar produtos");
            System.out.println("3 - Listar/adicionar/modificar/eliminar clientes");
            System.out.println("4 - Listar/adicionar/modificar/eliminar transporte");
            System.out.println("5 - Terminar sessão");
            System.out.println("0 - Terminar programa");
            System.out.println("OP-> ");
            op = ler.nextInt();

            switch (op) {
            case 1:break;
            case 2:break;
            case 3: menuClientes();break;
            case 4: menuTransporte(); break;
            case 5: return;
            default:
                System.out.println("Opção inválida");
            }
        }
    }

    public static void main(String[] args) {

        int op;
        ler = new Scanner(System.in); //the declarion of this variable was put on the class itself to be accessible by all methods

        do {
            System.out.println("1 - Iniciar sessão");// login
            System.out.println("0 - Terminar programa");
            System.out.print("OP-> ");
            op = ler.nextInt();


            switch (op) {
            case 1: menuPrincipal();break;

            default:
                System.out.println("Opção inválida");
            }

        } while (op != 0);
    }