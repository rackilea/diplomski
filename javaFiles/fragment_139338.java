final class Response<T> {
    final Status status = null;
    final T response = null;
}

final class Status {
    final int error = Integer.valueOf(0);
    final int code = Integer.valueOf(0);
    final String message = null;
}

final class ProfileAndAccessToken {
    final Profile profile = null;
    @SerializedName("access_token") final String accessToken = null;
}

final class Profile {
    final int id = Integer.valueOf(0);
    final String username = null;
    @SerializedName("full_name") final String fullName = null;
    final String phone = null;
    final int verified = Integer.valueOf(0);
    final int admin = Integer.valueOf(0);
    @SerializedName("allow_dev") @JsonAdapter(BooleanToIntTypeAdapter.class) final int allowDev = Integer.valueOf(0);
    final Company company = null;
}

final class Company {
    final int id = Integer.valueOf(0);
    final String name = null;
    final String email = null;
    final String sample = null;
    final URL logo = null;
}