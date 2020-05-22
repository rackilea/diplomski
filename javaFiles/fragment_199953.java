private Recipe(Parcel in) {
        id = in.readInt();
        name =in.readString();
        ingredients = in.readList();
        method = in.readList();
        comment = in.readString();
        }