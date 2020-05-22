while(currentSegment != initialSegment && currentHeading != initialHeading)
    if currentSegment.blocked(currentHeading) {
        currentHeading = currentHeading.turnClockwise()
    } else {
        currentSegment = currentSegment.stepToward(currentHeading)
    }
    vertexData.appendToClockwiseHeading(currentHeading, currentSegment)
}