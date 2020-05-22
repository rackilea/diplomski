package demo

class DemoController {

    def saveCreateFunding(CreateFundingCommand createFundingCommand){
        if(createFundingCommand.hasErrors()){
            render 'Errors were found'
        }else{
            render 'No errors were found'
        }
    }
}