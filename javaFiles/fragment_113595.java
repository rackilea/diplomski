import Foundation

extension URLRequest {

    private static let alloweCharacters = CharacterSet(charactersIn: "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 -_.*")

    public mutating func setURLEncodedFormData(parameters: [String: String?]) {

        var encodedParameters = ""

        for (key, value) in parameters {

            if !encodedParameters.isEmpty {
                encodedParameters += "&"
            }

            encodedParameters += URLRequest.urlEncoded(value: key)
            encodedParameters += "="
            if let value = value {
                encodedParameters += URLRequest.urlEncoded(value: value)
            }
        }

        self.setValue("application/x-www-form-urlencoded", forHTTPHeaderField: "Content-Type")
        self.httpBody = encodedParameters.data(using: .utf8)
    }


    private static func urlEncoded(value: String) -> String {

        return value.addingPercentEncoding(withAllowedCharacters: alloweCharacters)!.replacingOccurrences(of: " ", with: "+")
    }


}