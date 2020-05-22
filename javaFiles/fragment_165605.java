{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "iot:Subscribe",
      "Resource": "arn:aws:iot:<region>:<awsID>:topicfilter/$aws/things/<deviceID>/jobs/notify-next"
    },
    {
      "Effect": "Allow",
      "Action": "iot:Receive",
      "Resource": "arn:aws:iot:<region>:<awsID>:topic/$aws/things/<deviceID>/jobs/notify-next"
    },
    {
      "Effect": "Allow",
      "Action": "iot:Publish",
      "Resource": "arn:aws:iot:<region>:<awsID>:topic/some"
    },
    {
      "Effect": "Allow",
      "Action": "iot:Connect",
      "Resource": "arn:aws:iot:<region>:<awsID>:client/<deviceID>"
    },
    {
      "Effect": "Allow",
      "Action": [
        "iot:UpdateJobExecution",
        "iot:StartNextPendingJobExecution"
        ],
      "Resource": "arn:aws:iot:<region>:<awsID>:thing/<deviceID>"
    }
  ]
}