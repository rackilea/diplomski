public void writeToParcel (Parcel dest, int flags)
{
    dest.writeInt(index);
    dest.writeBoolean(isSection);
    dest.writeString(volumeLink);
    dest.writeString(rowId);
    dest.writeString(cfr);      

}