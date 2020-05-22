import java.util.Scanner;

public class Teste {

public static void main(String args[]) {

MeuProjecto meuProjecto = new MeuProjecto();
Scanner scanner = new Scanner(System.in);
boolean sair = false;
while (!sair) {

    String menu = scanner.nextLine();
    System.out.println(menu);
    switch(menu){
        case "VCP":
            System.out.println("VCP P");
            break;
        case "PNM":
            System.out.println("PNM");
            break;
        case "PME":
            meuProjecto.PME();
            break;
        case "CMA":
            meuProjecto.CMA();
            break;
        case "ECP":
            meuProjecto.ECP();
        case "MCA":
            meuProjecto.MCA();
            break;
        default:
            System.out.println("Opção inválida!");
        case "A": 
            System.out.println("VCP ­ Ver a conversa em progresso");
            System.out.println("PNM ­ Publicar nova mensagem ");
            System.out.println("PME - Publicar mensagem encriptada");
            System.out.println("CMA - Corrigir mensagem anterior");
            System.out.println("ECP - Encerrar conversa em progresso");
            System.out.println("MCA - Mostrar conversas anteriores");
            System.out.println("A - Ajuda");
            System.out.println("S - Sair");
            break;
        case "S":
            sair = true;
    }

}

}

}