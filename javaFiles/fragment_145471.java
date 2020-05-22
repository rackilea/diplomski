// your Alarm(Parcel in)
hours = in.readInt();
minutes = in.readInt();
alarmTime = in.readInt();
in.readBooleanArray(days);
// Your write function:
 dest.writeInt(hours);
dest.writeInt(minutes);
dest.writeInt(alarmTime);
dest.writeInt(ID);
dest.writeBooleanArray(days);