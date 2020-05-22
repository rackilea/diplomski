if (message instanceof CA) {
            int mode = ((CA) message).mode;
            this.originator = getContext().sender();
            switch(mode){
            case 1: //SMS
                 break;
             case 2: //Email
                 break;
             case 3: //Notification
                 notificationActor.tell(new NA((CA)message), getSelf());
                 break;
            }
        }
        else if (message instanceof Response) {
            originator.tell(((Response) message).getResponse(), getSelf());
        }
        else{
            unhandled(message);
        }