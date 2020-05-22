public Transport getTransportByDate(Date date){
        for (Map.Entry<String, Transport> entry : this.transport.entrySet()){
                if (date.equals(entry.getValue().getDate()) {
                        return entry.getValue();
                }
        }
}