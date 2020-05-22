require 'openssl'

digest  = OpenSSL::Digest::Digest.new('sha1')
secret = "12345678901234567890"
movingFactor = "0"
hash = OpenSSL::HMAC.hexdigest(digest, secret, movingFactor)
puts "Hash: #{hash}"