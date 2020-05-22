package demo

@grails.validation.Validateable
class CreateFundingCommand extends BaseCommand {
    Set<Cause> causes
}