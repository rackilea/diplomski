@SpringBootApplication
public class NestideasFacturasApplication implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;

    public static void main(String[] args) {
        SpringApplication.run(NestideasFacturasApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) {

        //Your test scenario
        System.out.println("Application démarrée");
        System.out.println(clienteService);

        clienteService.agregarCliente(new Cliente("16565465", "Hassan", "JROUNDI", "Said Hajji", "0662165537", "hassan.jroundi@outlook.fr", TipoCliente.EMPREZA, "Salé"));

    }
}