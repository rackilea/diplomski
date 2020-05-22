public class NotificationCenterA extends NotificationCenter {    
    private final TemplateBuildingService templateBuildingService;

    public NotificationCenterA(EmailService emailService, TemplateBuildingService templateBuildingService) {
       super(emailService);
       this.templateBuildingService = templateBuildingService;
    }
}