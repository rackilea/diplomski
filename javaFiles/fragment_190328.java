let task = session.dataTaskWithRequest(request, completionHandler: {(data, response ,error ) in
        if let response = response {
            let httpResponse = response as! NSHTTPURLResponse
            print("response code = \(httpResponse.statusCode)")
        }
    })
task.resume()