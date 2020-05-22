@RabbitListener(queues = QUEUE, containerFactory = "adapterOPListenerContainerFactory")
public void listen(HashMap<String, DTO> dtos) {
    System.out.println("Result:" + dtos.getClass() + ":" + dtos);
    DTO dto = dtos.entrySet().iterator().next().getValue();
    System.out.println(dto);
    latch.countDown();
}