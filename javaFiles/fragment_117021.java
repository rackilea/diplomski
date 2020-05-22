# Line 1 - 22 should be in your intent function
sessionAttributes =  dict()
if 'sessionAttributes' in event['session']: 
    sessionAttributes = event['session']['sessionAttributes']

if not sessionAttributes.has_key('AllQuestions') : 
    # Make the GET REQUEST
    Questions = ["all", "of", "your", "Questions", "stored", "in", "a", "list"]
    sessionAttributes['AllQuestions'] = Questions
    sessionAttributes['LastQuestionIndex'] = -1


Answer = getSlotValue('Answer')
if Answer != None:
    # AllAnswers is a dictionary which has key as the question number and value is the answer
    # AllAnswers = {
    #   0 : "Answer to your first question",
    #   1 : "Answer to your second question"
    # }
    AllAnswers[sessionAttributes['LastQuestionIndex']] = Answer

return ansNextQuestion(sessionAttributes)


def askNextQuestion(sessionAttributes) :
    Last = sessionAttributes['LastQuestionIndex']
    sessionAttributes['LastQuestionIndex'] = Last + 1

    if Last < len(sessionAttributes['AllQuestions']): 
        outputSpeech = "Your next question is " + sessionAttributes['AllQuestions'][Last + 1]
        return {
            "version": "1.0",
            "sessionAttributes": sessionAttributes,
            "response": {
                "outputSpeech": {
                    "type": "PlainText",
                    "text": outputSpeech
                },
                "shouldEndSession": False,
                "directives": [
                    {
                        "type": "Dialog.ElicitSlot",
                        "slotToElicit": "Question",
                        "updatedIntent": {
                            "name": "GetMovieDetails",
                            "confirmationStatus": "NONE",
                            "slots": {
                                "Answer": {
                                    "name": "Answer",
                                    "value": "NONE" # You can change the value of Answer to get new answer, this is allowed.
                                }
                            }
                        }
                    }
                ]
            }
        }
    else : 
        # You are out of questions, now proceed to what you should do after getting all the answers.