class DeviceController
  class << self
    def my_public_device;  @my_public_device  ||= Device['mydevice'] end

    private

    def my_private_device; @my_private_device ||= Device['mydevice'] end
  end
end