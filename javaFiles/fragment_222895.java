prevRespondentId = recordDataList.get(0).getRespondentId(); //Initialize to first or default value probably -1?

    for (RecordData recordData : recordDataList) {
                if (recordData.getRespondentId() != prevRespondentId) {
                rowDataNumber++;
            }
            prevRespondentId = recordData.getRespondentId();
        }