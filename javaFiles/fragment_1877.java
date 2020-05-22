mEvent.setPlace(placeString);
            mEvent.setDate(dateString);
            mEvent.setType(mType);
            mEvent.setWindPower(wind_power);
            mEvent.setWaveSize(wave_size);
            mEvent.setConditions(mConditions);
            mEvent.setComment(commentString);

            Map<String, Object> eventValues = mEvent.toMap();
            mEventsDatabaseReference.child(mEvent.getId()).updateChildren(eventValues);