require 'facter'

Facter.add(:app_v2) do
  confine :kernel => :Linux
  setcode do
    result = false
    if Facter::Core::Execution.exec('dpkg -l | grep app|awk \'{print$3}\'| cut -c1') == '2'
      result = true
    end
    result
  end
end