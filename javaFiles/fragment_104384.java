public interface IChannelSetting<T> {

    public T getDefaultValue();

}


public enum ChannelSettingInteger implements IChannelSetting<Integer> {

    CHANNEL_LOOKBACK(50);

    private Integer defaultValue;

    ChannelSettingInteger(Integer defaultValue) {
      this.defaultValue = defaultValue;
    }

    @Override
    public Integer getDefaultValue() {
      return defaultValue;
    }
}