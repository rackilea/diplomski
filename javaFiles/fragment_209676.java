@Component
@RabbitListener(queues = "FilaSoftware")
public class EventFilter {

    private final static Logger logger = LoggerFactory.getLogger(EventFilter.class);

    @RabbitHandler
    public void receiver(UsuarioModel fileBody) {
        System.out.println("Mensagem Nome - " + fileBody.getNome() + " com a idade " + String.valueOf(fileBody.getIdade()));
    }

    @RabbitHandler
    public void receiver(AlunoModel aluno) {
        System.out.println("Aluno Nome - " + String.valueOf(aluno.getNomeAluno()) + " sala - " + String.valueOf(aluno.getSalaAluno()) + " numero - " + String.valueOf(aluno.getNumeroAluno()));
    }
}